# Openapi Generator Reproducer


## TL;DR


1. Run the backend with
    ```shell
    ./mvnw clean quarkus:dev
    ```

1. Check that uploading works by uploading this README.md for example:
    ```shell
    curl -X POST \
      http://localhost:8080/api/something/upload \
      -H "Content-Type: multipart/form-data" \
      -F "uploadFile=@README.md"
    ```

1. In the frontend "project" run
    ```shell
    rm -rf ./src/api
    npm run openapi:codegen
    ```
    (don't forget `npm i`)

1. You should now have a generated SomethingApiApi (no naming settings) that contains an `objectToJSON` function that is not declared anywhere

## About

I think Openapi generator has a bug when dealing with Java/Kotlin/JVM in general (?) FileUpload types. This repo contains a very slim Quarkus/Kotlin project that exposes one multiform upload API.

When generating code (for a Svelte project) with typescript-fetch, there is a function `objectToJSON` that is not declared anywhere. The generated code therefore does not work.

You can check out openapi.json and Swagger, etc from `http://localhost:8080/q/dev-ui` when running the backend.
