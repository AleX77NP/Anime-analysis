import org.apache.spark.sql.types.{FloatType, IntegerType, StringType, StructField, StructType}

object Schemas {

  val animeSchema = StructType(Array(
    StructField("anime_id", IntegerType, nullable = false),
    StructField("name", StringType, nullable = false),
    StructField("genre", StringType, nullable = false),
    StructField("type", StringType, nullable = false),
    StructField("episodes", IntegerType, nullable = false),
    StructField("rating", FloatType, nullable = false),
    StructField("members", IntegerType, nullable = false),
  ))

  val ratingSchema = StructType(Array(
    StructField("user_id", IntegerType, nullable = false),
    StructField("anime_id", IntegerType, nullable = false),
    StructField("rating", IntegerType, nullable = false)
  ))
}
