import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.6.0"
    `maven-publish`
}

group = "me.jskeen"
version = "1.0-SNAPSHOT"

dependencies {
    testImplementation("org.jetbrains.kotlin:kotlin-test:1.6.0")
    api(project(":depA"))
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = "me.joshskeen"
            artifactId = "mainmodule"
            version = "1.0"
            from(components["java"])
        }
    }
}

tasks.test {
    useJUnit()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}