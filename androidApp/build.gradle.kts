plugins {
	id("com.android.application")
	kotlin("android")
	id("kotlin-android-extensions")
	id("kotlin-android")
}
group = "com.wpaul15.cookbook"
version = "1.0-SNAPSHOT"

repositories {
	gradlePluginPortal()
	google()
	jcenter()
	mavenCentral()
}
dependencies {
	implementation("androidx.legacy:legacy-support-v4:1.0.0")
	implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.2.0")
	val navVersion = "2.3.0"

	implementation(project(":shared"))
	implementation("com.google.android.material:material:1.2.1")
	implementation("androidx.appcompat:appcompat:1.2.0")
	implementation("androidx.constraintlayout:constraintlayout:2.0.1")
	implementation("androidx.recyclerview:recyclerview:1.1.0")
	implementation("androidx.recyclerview:recyclerview-selection:1.1.0-rc02")
	implementation("androidx.lifecycle:lifecycle-extensions:2.2.0")
	implementation("androidx.fragment:fragment-ktx:1.2.5")

	implementation("androidx.navigation:navigation-fragment:$navVersion")
	implementation("androidx.navigation:navigation-ui:$navVersion")
	implementation("androidx.navigation:navigation-fragment-ktx:$navVersion")
	implementation("androidx.navigation:navigation-ui-ktx:$navVersion")
	implementation("androidx.navigation:navigation-dynamic-features-fragment:$navVersion")

	androidTestImplementation("androidx.navigation:navigation-testing:$navVersion")
}
android {
	compileSdkVersion(30)
	defaultConfig {
		applicationId = "com.wpaul15.cookbook.androidApp"
		minSdkVersion(26)
		targetSdkVersion(30)
		versionCode = 1
		versionName = "1.0"
	}
	buildTypes {
		getByName("release") {
			isMinifyEnabled = false
		}
	}
	buildFeatures {
		viewBinding = true
	}
	kotlinOptions {
		jvmTarget = "11"
	}
	sourceSets {
		getByName("main").res.srcDirs(
			"src/main/res",
			"src/main/res/layouts",
			"src/main/res/layouts/main",
			"src/main/res/layouts/recipe"
		)
	}
}