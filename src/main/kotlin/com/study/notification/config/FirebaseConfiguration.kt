package com.study.notification.config

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.ClassPathResource

@Configuration
class FirebaseConfiguration {

    val fileName = "service-account.json"

    @Bean
    fun firebaseInitialize(){
        val fileInputStream = ClassPathResource(fileName).inputStream

        val options = FirebaseOptions.builder()
            .setCredentials(GoogleCredentials.fromStream(fileInputStream)).build()

        FirebaseApp.initializeApp(options)
    }
}