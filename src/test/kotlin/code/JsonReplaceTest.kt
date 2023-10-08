package code

import org.json.JSONArray
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.File

internal class JsonReplaceTest {
    private val obj = JsonReplace()


    @Test
    fun testGetResult() {
        val newDataArray = JSONArray()
        newDataArray.put("=)")
        newDataArray.put("=(")
        obj.newDataArray = newDataArray
        obj.getResult()
        val resultFile = File("result.json")
        val expectedJsonArray = "[\n  \"=)\",\n  \"=(\"\n]"
        val fileContents = resultFile.readText()
        assertEquals(expectedJsonArray, fileContents)
    }


    @Test
    fun testReplaceJsonField() {
        val dataArray = JSONArray()
        dataArray.put("Hello, replace me!")
        dataArray.put("This is a wrong test.")
        obj.dataArray = dataArray
        val clearReplacements = mutableMapOf("replace me!" to "user", "wrong" to null)
        obj.clearReplacements = clearReplacements
        obj.replaceJsonField()
        val expectedNewDataArray = JSONArray()
        expectedNewDataArray.put("Hello, user")
        expectedNewDataArray.put("This is a  test.")
        assertEquals(expectedNewDataArray.toString(), obj.newDataArray.toString())
    }


}
