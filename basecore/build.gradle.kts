plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    id("maven-publish")
}

android {
    namespace = "com.vurtnewk.core"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
        debug {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

afterEvaluate{
    publishing {
        publications {
            // 定义发布的类型为 AAR
            create<MavenPublication>("debug") {
                from(components.getByName("debug")) // 使用 release 版本的组件
                // 配置 POM 信息
                groupId = "com.vurtnewk.core" // 替换为你的实际 groupId
                artifactId = "basecore" // 替换为你的实际 artifactId
                version = "1.0.0" // 版本号
            }
        }
        // 发布到本地 Maven 仓库
        repositories {
            mavenLocal{
                maven {
                    url = uri("/Users/vurtnewk/Documents/data/environment/local-repo") // 设置本地 Maven 仓库路径
                }
            }

        }
    }

}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    api(libs.logger)
}