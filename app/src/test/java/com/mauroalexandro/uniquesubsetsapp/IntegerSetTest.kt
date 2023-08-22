package com.mauroalexandro.uniquesubsetsapp

import org.junit.Assert.assertEquals
import org.junit.Test

class IntegerSetTest {
    private lateinit var integerSet: IntegerSet

    @Test
    fun `The expected uniquesubset is the same as returned`() {
        integerSet = IntegerSet.getInstance()

        val uniqueSubSetsReturned = integerSet.getUniqueSubset(getIntegerSet())
        assertEquals(expectedUniqueSubSets(), uniqueSubSetsReturned)
    }

    /**
     * The initial Integer Set is Created
     */
    private fun getIntegerSet(): MutableList<Int> {
        //Create and Array of Integers - Set
        val integerSetArray: MutableList<Int> = ArrayList()
        integerSetArray.add(1)
        integerSetArray.add(2)
        return integerSetArray
    }

    /**
     * Expected List of UniqueSubSets
     */
    private fun expectedUniqueSubSets(): MutableList<List<Int>?> {
        val allUniqueSubSets: MutableList<List<Int>?> = ArrayList()

        //Adding several expected Arrays
        val firstArrayList: ArrayList<Int> = ArrayList()
        firstArrayList.add(1)
        val secondArrayList: ArrayList<Int> = ArrayList()
        secondArrayList.add(1)
        secondArrayList.add(2)
        val thirdArrayList: ArrayList<Int> = ArrayList()
        thirdArrayList.add(2)

        //Adding the arrays to the allUniqueSubSets List
        allUniqueSubSets.add(0, firstArrayList)
        allUniqueSubSets.add(1, secondArrayList)
        allUniqueSubSets.add(2, thirdArrayList)

        return allUniqueSubSets
    }
}