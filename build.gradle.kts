import java.util.*
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val props = project.rootProject.file("local.properties").takeIf { it.exists() }?.let {
    Properties().apply { load(it.inputStream()) }
}

plugins {
    kotlin("multiplatform") version "1.4.0"
    id("org.jetbrains.dokka") version "1.4.20-dev-10"
    `maven-publish`
}
group = "io.github.detachhead"
version = "2.0"
repositories {
    mavenCentral()
    jcenter()
    maven("https://maven.pkg.jetbrains.space/kotlin/p/dokka/dev")
}

tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions.useIR = true
}

kotlin {
    explicitApi()
    js { nodejs() }
    jvm {}
    mingwX64 {}
    sourceSets {
        @Suppress("unused_variable")
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }

        @Suppress("unused_variable")
        val jvmTest by getting {
            dependencies {
                implementation(kotlin("test-junit"))
            }
        }

        @Suppress("unused_variable")
        val jsTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-js"))
            }
        }

        @Suppress("unused_variable")
        val mingwX64Test by getting { }
    }
    configure(listOf(targets["metadata"], jvm(), js())) {
        mavenPublication {
            val targetPublication = this@mavenPublication
            tasks.withType<AbstractPublishToMaven>()
                .matching { it.publication == targetPublication }
                .all { onlyIf { findProperty("isMainHost") == "true" } }
        }
    }
}

publishing {
    publications {
        create<MavenPublication>(project.name) {
            groupId = project.group.toString()
            artifactId = project.name
            version = project.version.toString()
        }
        publishing.publications.map {
            it.name
        }.find {
            it != "kotlinMultiplatform"
        }
    }
}

afterEvaluate {
    configure<PublishingExtension> {
        publications.all {
            val mavenPublication = this as? MavenPublication
            mavenPublication?.artifactId =
                "${project.name}${"-$name".takeUnless { "kotlinMultiplatform" in name }.orEmpty()}"
        }
    }
}

configure<PublishingExtension> {
    publications {
        withType<MavenPublication> {
            groupId = project.group.toString()
            artifactId = project.name
            version = project.version.toString()
        }
    }
    props?.let {
        repositories {
            val (owner, project) = System.getenv("GITHUB_REPOSITORY").toLowerCase().split('/')
            maven("https://maven.pkg.github.com/$owner/$project") {
                credentials {
                    username = owner
                    password = System.getenv("GITHUB_TOKEN")
                }
            }
        }
    }
}
