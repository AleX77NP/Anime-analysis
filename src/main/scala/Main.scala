import org.apache.spark.sql.SparkSession

object Main {


  def main(args: Array[String]): Unit = {
    val spark = SparkSession
      .builder()
      .appName("Anime_Analysis")
      .master("local[*]")
      .getOrCreate()

    val animeDF = spark.read
      .option("header", "true")
      .schema(Schemas.animeSchema)
      .format("csv")
      .load("data/anime.csv")

    val ratingDF = spark.read
      .option("header", "true")
      .schema(Schemas.ratingSchema)
      .format("csv")
      .load("data/rating.csv")

    // animeDF.show(10)
    // ratingDF.show(10)

//    animeDF.join(ratingDF, animeDF("anime_id") === ratingDF("anime_id"), "inner" )
//      .show(false)

    animeDF.createTempView("ANIME")
    ratingDF.createTempView("RATING")

    // top 10 best rated animes of all time
    val topRatedAnimeDF = spark.sql("SELECT name, rating FROM ANIME WHERE rating > 9 AND type = 'TV' ")
    topRatedAnimeDF.show(10)
  }
}
