// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose) apply false

    // for kotlinx serialization
    alias(libs.plugins.kotlin.serialization) apply false

    // for accessing secrets.properties file
    alias(libs.plugins.google.secrets) apply false

    // for connecting with Firebase
    id("com.google.gms.google-services") version "4.4.2" apply false
}