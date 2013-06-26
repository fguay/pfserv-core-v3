package fr.canal.vod.test

import com.mongodb.BasicDBObject
import com.mongodb.DB
import com.mongodb.DBCollection
import com.mongodb.Mongo
import de.flapdoodle.embed.mongo.MongodExecutable
import de.flapdoodle.embed.mongo.MongodProcess
import de.flapdoodle.embed.mongo.MongodStarter
import de.flapdoodle.embed.mongo.config.MongodConfig
import de.flapdoodle.embed.mongo.distribution.Version
import de.flapdoodle.embed.process.runtime.Network
import org.junit.After
import org.junit.Before
import org.junit.Test
import java.util.Date

object DocumentTestCase {
  private final val DATABASE_NAME: String = "embedded"
}

class DocumentTestCase {
  @Before def beforeEach {
    val runtime: MongodStarter = MongodStarter.getDefaultInstance
    mongodExe = runtime.prepare(new MongodConfig(Version.Main.PRODUCTION, 12345, Network.localhostIsIPv6))
    mongod = mongodExe.start
    mongo = new Mongo("localhost", 12345)
  }

  @After def afterEach {
    if (this.mongod != null) {
      this.mongod.stop
      this.mongodExe.stop
    }
  }

  @Test def shouldCreateNewObjectInEmbeddedMongoDb {
    val db: DB = mongo.getDB(DATABASE_NAME)
    val col: DBCollection = db.createCollection("testCollection", new BasicDBObject)
    col.save(new BasicDBObject("testDoc", new Date))
  }

  private var mongodExe: MongodExecutable = null
  private var mongod: MongodProcess = null
  private var mongo: Mongo = null
}