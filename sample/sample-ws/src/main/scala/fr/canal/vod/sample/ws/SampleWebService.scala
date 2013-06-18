package fr.canal.vod.ws

import javax.ws.rs.{QueryParam, GET, Path}
import fr.canal.vod.api.sample.dto.Sample


trait SampleWebService {

  @Path("/sample")
  @GET
  def sample(@QueryParam("param") param : String) : Sample

}