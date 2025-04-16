plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.nt118p21_22520047_baitaplab03"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.nt118p21_22520047_baitaplab03"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    packagingOptions {
        exclude("META-INF/INDEX.LIST")
        exclude("META-INF/DEPENDENCIES")
        exclude("META-INF/LICENSE")
        exclude("META-INF/LICENSE.txt")
        exclude("META-INF/NOTICE")
        exclude("META-INF/NOTICE.txt")
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation(files("src\\main\\libs\\ant-1.10.14.jar"))
    implementation(files("src\\main\\libs\\ant-junit-1.10.14.jar"))
    implementation(files("src\\main\\libs\\ant-launcher-1.10.14.jar"))
    implementation(files("src\\main\\libs\\jeval-0.9.4.jar"))
    implementation(files("src\\main\\libs\\junit-4.13.2.jar"))
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
}

