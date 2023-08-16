settingsEvaluated {
    // Using the API, provides a lazy Provider<String>
    println(providers.gradleProperty("BOBS_PARAM").get())
    println(providers.gradleProperty("WORKLOAD_BOBS_BUILD_PARAM").get())
}