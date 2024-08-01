import jakarta.ws.rs.Consumes
import jakarta.ws.rs.POST
import jakarta.ws.rs.Path
import jakarta.ws.rs.core.MediaType
import org.jboss.resteasy.reactive.RestForm
import org.jboss.resteasy.reactive.multipart.FileUpload

@Path("/api/something/")
class SomeApi {

    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Path("/upload")
    fun upload(@RestForm uploadFile: FileUpload): String {

        println("Doing something with ${uploadFile.fileName()}")

        return "Just some random return"
    }
}