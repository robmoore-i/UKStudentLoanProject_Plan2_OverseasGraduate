@file:Suppress("UnstableApiUsage")

plugins {
    java
    `jvm-test-suite`
    application
    id("com.gradleup.shadow") version "9.1.0"
}

repositories {
    mavenCentral()
}

testing {
    suites {
        named<JvmTestSuite>("test") {
            useJUnitJupiter("5.13.4")
        }
    }
}

application {
    mainClass.set("uk.org.studentloan.Main")
}
