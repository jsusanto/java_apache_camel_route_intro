# java_apache_camel_route_intro
Java using Apache Camel Route, Maven

# Step 1: Set up a Maven Project (pom.xml)
```
<properties>
    <maven.compiler.source>21</maven.compiler.source>
    <maven.compiler.target>21</maven.compiler.target>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <camel.version>3.20.2</camel.version>
</properties>

<dependencies>
    <dependency>
        <groupId>org.apache.camel</groupId>
        <artifactId>camel-core</artifactId>
        <version>${camel.version}</version>
    </dependency>
    <dependency>
        <groupId>org.apache.camel</groupId>
        <artifactId>camel-main</artifactId>
        <version>${camel.version}</version>
    </dependency>
    <dependency>
        <groupId>org.apache.camel</groupId>
        <artifactId>camel-file</artifactId>
        <version>${camel.version}</version>
    </dependency>
    <dependency>
        <groupId>org.slf4j</groupId>
        <artifactId>slf4j-simple</artifactId>
        <version>2.0.13</version>
    </dependency>
</dependencies>
```

# Step 2: Create a Camel Route in src/main/java/MyRouteBuilder.java

Create a class that extends RouteBuilder:
```
import org.apache.camel.builder.RouteBuilder;

public class MyRouteBuilder extends RouteBuilder {
    @Override
    public void configure() {
        from("file:data/inbox?noop=true")
                .log("Processing file: ${file:name}")
                .to("file:data/outbox");
    }
}
```

# Step 3: Create a Main Class to Run It src/main/java/Application.java
```
import org.apache.camel.main.Main;

public class Application {
    public static void main(String[] args) throws Exception {
        Main main = new Main();
        System.out.println("Done running!");
        main.configure().addRoutesBuilder(new MyRouteBuilder());
        main.run();
    }
}
```

# Step 4: Create Input/Output Folders
In your project root, create:
- data/inbox
- data/outbox

Put a test file (e.g., hello.txt) in data/inbox.

# Step 5: Run the App
Right-click Application.java → Run 'Application.main()'.

You should see log output and the file copied to data/outbox.