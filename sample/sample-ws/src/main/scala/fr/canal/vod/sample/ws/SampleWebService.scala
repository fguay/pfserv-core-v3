package fr.canal.vod.sample.ws

import javax.ws.rs.{QueryParam, GET, Path}
import fr.canal.vod.sample.api.dto.Sample

trait SampleWebService {

  @Path("/jpasample")
  @GET
  def jpaSample(@QueryParam("param") param : String) : Sample

  @Path("/docsample")
  @GET
  def docSample(@QueryParam("param") param : String) : Sample

}