buildscript {
	repositories {
		gradlePluginPortal()
		jcenter()
		google()
		mavenCentral()
	}
	dependencies {
		classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.4.10")
		classpath("com.android.tools.build:gradle:4.1.0")
		classpath("com.google.dagger:hilt-android-gradle-plugin:2.29-alpha")
	}
}
group = "com.wpaul15.cookbook"
version = "1.0-SNAPSHOT"

repositories {
	google()
	mavenCentral()
}
