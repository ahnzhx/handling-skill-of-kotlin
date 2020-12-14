package coroutineSample

import org.springframework.context.annotation.Configuration

@Configuration
class ProductRouter (
    private val productRepository: ProductRepository,
    private val kafkaProducer: KafkaProducer,
    private val webClient: WebClient
        ){
}