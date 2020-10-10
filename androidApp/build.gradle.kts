plugins {
	id("com.android.application")
	kotlin("android")
	id("kotlin-android-extensions")
	id("kotlin-android")
	kotlin("kapt")
	id("dagger.hilt.android.plugin")
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
	implementation(project(":shared"))
	implementation("androidx.legacy:legacy-support-v4:1.0.0")
	implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.2.0")
	implementation("com.google.android.material:material:1.2.1")
	implementation("androidx.appcompat:appcompat:1.2.0")
	implementation("androidx.constraintlayout:constraintlayout:2.0.2")
	implementation("androidx.recyclerview:recyclerview:1.1.0")
	implementation("androidx.recyclerview:recyclerview-selection:1.1.0-rc03")
	implementation("androidx.lifecycle:lifecycle-extensions:2.2.0")
	implementation("androidx.fragment:fragment-ktx:1.2.5")
	implementation("com.google.dagger:hilt-android:2.29-alpha")
	implementation("androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha02")
	implementation("androidx.preference:preference:1.1.1")
	kapt("androidx.hilt:hilt-compiler:1.0.0-alpha02")
	kapt("com.google.dagger:hilt-android-compiler:2.29-alpha")

	val navVersion = "2.3.0"
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
		jvmTarget = "1.8"
	}
	compileOptions {
		sourceCompatibility = JavaVersion.VERSION_1_8
		targetCompatibility = JavaVersion.VERSION_1_8
	}
	sourceSets {
		getByName("main").res.srcDirs(
			"src/main/res",
			"src/main/res/layouts",
			"src/main/res/layouts/fragment",
			"src/main/res/layouts/main",
			"src/main/res/layouts/recipe",
			"src/main/res/layouts/settings"
		)
	}
}
