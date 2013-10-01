package fr.canal.vod.test

import org.dbunit.DataSourceBasedDBTestCase
import org.dbunit.database.{IDatabaseConnection, DatabaseConfig}
import javax.sql.DataSource
import org.junit.{Ignore, Assert, After, Before}
import java.sql.{ResultSet, Statement}
import org.dbunit.util.fileloader.FlatXmlDataFileLoader
import org.dbunit.dataset.IDataSet
import scala.collection.mutable
import org.springframework.beans.factory.annotation.Autowired
import org.dbunit.ext.hsqldb.HsqldbConnection

abstract class EntityTestCase extends DataSourceBasedDBTestCase {

  @Autowired
  var dataSource: DataSource = _


  val REQUEST: String = "select TABLE_SCHEM, TABLE_NAME from INFORMATION_SCHEMA.system_tables where table_type='TABLE'"

   override def setUpDatabaseConfig(config: DatabaseConfig) {
      config.setProperty(DatabaseConfig.FEATURE_QUALIFIED_TABLE_NAMES, true)
   }

  @Before
  @throws[Exception]
  def load() {
    super.setUp()
  }

  @After
  def  clear() {
    try {
      this.synchronized {
         val c: IDatabaseConnection = getConnection
         val s: Statement = c.getConnection.createStatement()
         s.execute("SET DATABASE REFERENTIAL INTEGRITY FALSE")
         val tables: mutable.HashSet[String] = new mutable.HashSet[String]()

        val rs: ResultSet = s.executeQuery(REQUEST)
        while (rs.next()) {
          if (!rs.getString(2).startsWith("DUAL_")) {
            tables.add(rs.getString(1) + "." + rs.getString(2))
          }
        }
        rs.close()
        for ( table:String <- tables) {
          s.executeUpdate("TRUNCATE TABLE " + table)
        }
        s.execute("SET DATABASE REFERENTIAL INTEGRITY TRUE")
        s.close()
        c.close()
      }
    } catch {
        case e:Exception => Assert.fail(e.getMessage)
    }
  }

  @throws[Exception]
  def getDataSet: IDataSet = {
    this.synchronized {
      return new FlatXmlDataFileLoader().load("/" + (this.getClass.getName.replace(".", "/") +".xml"))
    }
  }

  def getDataSource: DataSource = {
    dataSource
  }

}
