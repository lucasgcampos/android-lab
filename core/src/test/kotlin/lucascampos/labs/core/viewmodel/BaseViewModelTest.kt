package lucascampos.labs.core.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import lucascampos.labs.test.service.CallMock
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class BaseViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    lateinit var sut : BaseViewModel

    @Before
    fun setUp() {
        sut = BaseViewModelImpl()
    }

    @Test
    fun givenRequestWithSuccess_WhenMakeRequest_ThenViewStateBeSuccess() {
        // given
        val mockSuccess = CallMock.success("")

        // when
        sut.makeRequest(mockSuccess) {}

        // then
        assertEquals(ViewState.SUCCESS, sut.viewState.value)
    }

    @Test
    fun givenRequestWithError_WhenMakeRequest_ThenViewStateBeError() {
        // given
        val mockError = CallMock.error<Throwable>(Throwable())

        // when
        sut.makeRequest(mockError) {}

        // then
        assertEquals(ViewState.ERROR, sut.viewState.value)
    }

    @Test
    fun givenRequestWithError_WhenMakeRequest_ThenDefaultErrorIsSet() {
        // given
        val throwable = Throwable()
        val mockError = CallMock.error<Throwable>(throwable)

        // when
        sut.makeRequest(mockError) {}

        // then
        assertEquals(throwable, sut.defaultError.value)
    }
}

class BaseViewModelImpl : BaseViewModel()