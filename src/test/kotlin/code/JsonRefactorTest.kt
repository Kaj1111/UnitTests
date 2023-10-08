package code

import org.junit.jupiter.api.Test
import org.json.JSONArray
import org.junit.jupiter.api.Assertions.*

internal class JsonRefactorTest {
    private val obj = JsonRefactor()
    @Test
    fun testRefactorJsonArray() {

        obj.replacementArray = JSONArray("[{\"replacement\": \"replacement1\", \"source\": \"source1\"}, {\"replacement\": \"replacement2\", \"source\":null}, {\"replacement\": \"replacement1\", \"source\": \"source3\"}]")
        obj.refactorJsonArray()

        assertEquals(2, obj.clearReplacements.size)
        assertTrue(obj.clearReplacements.containsKey("replacement1"))
        assertEquals("source3", obj.clearReplacements["replacement1"])
    }
}
