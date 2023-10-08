package code

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

internal class JsonReadTest {
    private val obj = JsonRead()


    @Test
    fun getURLTest() {
        val input1 = "https://example.data.com"
        val input2 = "https://example.replacement.com"
        obj.getURL(input1, input2)
        assertNotNull(obj.dataUrl)
        assertNotNull(obj.replacementUrl)
        assertEquals(input1, obj.dataUrl.toString())
        assertEquals(input2, obj.replacementUrl.toString())
    }

    @Test
    fun getStringArrayTest() {
        val input1 = "https://raw.githubusercontent.com/thewhitesoft/student-2023-assignment/main/data.json"
        val input2 = "https://raw.githubusercontent.com/thewhitesoft/student-2023-assignment/main/replacement.json"
        obj.getURL(input1, input2)
        obj.getStringArray()
        assertNotNull(obj.dataArray)
        assertNotNull(obj.replacementArray)
        assertFalse(obj.dataArray.isEmpty)
        assertFalse(obj.replacementArray.isEmpty)
    }

}