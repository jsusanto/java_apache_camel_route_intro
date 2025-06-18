import org.apache.camel.builder.RouteBuilder;

public class MyRouteBuilder extends RouteBuilder {
    @Override
    public void configure() {
        from("file:data/inbox?noop=true")
                .log("Processing file: ${file:name}")
                .to("file:data/outbox");
    }
}
