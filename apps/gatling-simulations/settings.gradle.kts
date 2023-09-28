dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            from(files("../shared-bom/gradle/libs.versions.toml"))
        }
    }
}

includeBuild("../shared-bom")

rootProject.name = "gatling-simulations"
