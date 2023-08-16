plugins {
    id("org.springframework.boot") version "3.1.0"
    id("io.spring.dependency-management") version "1.1.0"
    id("org.graalvm.buildtools.native") version "0.9.20"
    id("java")
}

group = "com.vmware.tap.accelerators"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17
java.targetCompatibility = JavaVersion.VERSION_17

springBoot {
	buildInfo()
}

repositories {
    mavenCentral()
}

dependencies {
    // Spring
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-actuator")

    // Test
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<Test> {
    useJUnitPlatform()
    doLast {
        println("bob - using project.property from mounted gradle.properties: " + project.property("BOBS_PARAM"))
    }
}

tasks.named<Jar>("jar") {
    enabled = false
}

tasks.register("printBuildParams") {
    doLast {
        println("bob - workload defined env param, WORKLOAD_BOBS_BUILD_PARAM=" + System.getenv("WORKLOAD_BOBS_BUILD_PARAM"))
        println("bob - additional env params BOBS_PROPERTIES_PARAM=" + System.getenv("BOBS_PROPERTIES_PARAM"))
        println("bob - additional env params BOBS_BUILD_PARAM=" + System.getenv("BOBS_BUILD_PARAM"))
        println("bob - additional build props BOBS_PROPERTIES_PARAM=" + System.getProperty("BOBS_PROPERTIES_PARAM"))
        println("bob - additional build props BOBS_BUILD_PARAM=" + System.getProperty("BOBS_BUILD_PARAM"))
        println("bob - prop from system.getProperty BOBS_PARAM=" + System.getProperty("BOBS_PARAM"))
        println("bob - prop from gradle.properties BOBS_PARAM=" + project.property("BOBS_PARAM"))
    }
}

