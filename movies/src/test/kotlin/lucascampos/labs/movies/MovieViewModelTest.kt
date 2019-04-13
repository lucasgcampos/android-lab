package lucascampos.labs.movies

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import lucascampos.labs.movies.models.DiscoverResponse
import lucascampos.labs.movies.models.Movie
import lucascampos.labs.test.service.CallMock
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.Mockito.never
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MovieViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    private lateinit var viewModel: MovieViewModel

    @Mock
    lateinit var api: MovieApi

    @Before
    fun setUp() {
        viewModel = MovieViewModel(api)
    }

    @Test
    fun givenSuccessRequest_whenFetchMovies_thenMoviesIsNotNull() {
        // given
        val response = createSuccessfulResponse()
        `when`(api.fetchMovies()).thenReturn(CallMock.success(response))

        // when
        viewModel.fetchMovies()

        // then
        assertEquals(response, viewModel.movies.value)
    }

    @Test
    fun givenFailRequest_whenFetchMovies_thenErrorIsNotNull() {
        // given
        val errorResponse = Throwable()
        `when`(api.fetchMovies()).thenReturn(CallMock.error(errorResponse))

        // when
        viewModel.fetchMovies()

        // then
        assertEquals(errorResponse, viewModel.defaultError.value)
    }

    @Test
    fun givenMoviesNotNull_whenFetchMovies_thenNotFetchMovies() {
        // given
        viewModel.movies.value = createSuccessfulResponse()

        // when
        viewModel.fetchMovies()

        // then
        verify(api, never()).fetchMovies()
    }

    private fun createSuccessfulResponse() = DiscoverResponse(listOf(Movie(title = "Harry Potter", poster = "")))

}
