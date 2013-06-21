package fr.canal.vod.ws

import javax.ws.rs.{QueryParam, GET, Path}
import fr.canal.vod.api.sample.dto.Sample


trait SampleWebService {

  @Path("/jpasample")
  @GET
  def jpaSample(@QueryParam("param") param : String) : Sample

  @Path("/sqlsample")
  @GET
  def sqlSample(@QueryParam("param") param : String) : Sample

}