package coroutineSample

import org.springframework.stereotype.Repository

/**
 * 상품 정보에 접근하기 위한 R2DBC Repository
 *
 * @property [DatabaseClient]
 */
@Repository
class ProductRepository (private val client: DatabaseClient){

    /**
     * 상품 번호로 상품 정보를 조회한다.
     * @param id
     */

    suspend fun getProduct(id: Int): Product? {
        return client.execute()
    }
}
