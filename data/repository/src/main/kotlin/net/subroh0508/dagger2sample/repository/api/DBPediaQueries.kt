package net.subroh0508.dagger2sample.repository.api

import java.net.URLEncoder

internal fun buildQueryForAnimeFromFirstLetter(letter: String): String = """
    PREFIX dbo: <http://dbpedia.org/ontology/>
    PREFIX dct: <http://purl.org/dc/terms/>
    PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>
    PREFIX foaf:  <http://xmlns.com/foaf/0.1/>

    SELECT ?id ?title ?abstract ?wikipedia
    WHERE {
      ?anime dct:subject <http://ja.dbpedia.org/resource/Category:アニメ作品_${letter}>;
        dbo:wikiPageID ?id;
        dbo:abstract ?abstract;
        rdfs:label ?title;
        foaf:isPrimaryTopicOf ?wikipedia.
    }
    LIMIT 100
""".trimIndentAndBr().encode()

private fun String.trimIndentAndBr() = trimIndent().replace("[\n\r]", "")
private fun String.encode() = URLEncoder.encode(this, "UTF-8")
