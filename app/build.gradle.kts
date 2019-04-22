plugins { id("com.android.application") }

apply(from = "../share-config.gradle")

android {
    defaultConfig {
        applicationId = "lucascampos.labs"
    }
}

dependencies {
    implementation(project(path = ":core"))
    implementation(project(path = ":movies"))

    implementation(Dependency.appCompat)
    implementation(Dependency.constraintLayout)
    implementation(Dependency.navigationUiKtx)
    implementation(Dependency.navigationFragmentKtx)
}
