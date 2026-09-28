plugins {
	java
	`maven-publish`
	id("com.github.davidmc24.gradle.plugin.avro") version "1.9.1"
}

group = "com.kafka"
version = "0.0.1"

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.apache.avro:avro:1.11.3")
}

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

publishing {
	publications {
		create<MavenPublication>("maven") {
			from(components["java"])
		}
	}
}