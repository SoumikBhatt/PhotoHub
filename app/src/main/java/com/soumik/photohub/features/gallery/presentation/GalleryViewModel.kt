package com.soumik.photohub.features.gallery.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.soumik.photohub.core.utils.Constants
import com.soumik.photohub.core.utils.IConnectivity
import com.soumik.photohub.features.gallery.data.repositories.IGalleryRepository
import com.soumik.photohub.features.gallery.domain.models.PhotoListItem
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

class GalleryViewModel @Inject constructor(
    private val galleryRepository: IGalleryRepository,
    private val connectivity: IConnectivity
) : ViewModel() {

    companion object {
        private const val TAG = "GalleryViewModel"
    }

    private val _pagedPhotoList : MutableLiveData<PagingData<PhotoListItem>> = MutableLiveData()
    val pagedPhotoList : LiveData<PagingData<PhotoListItem>> get() = _pagedPhotoList

    private val _errorMessage: MutableLiveData<String> = MutableLiveData<String>()
    val errorMessage: LiveData<String> get() = _errorMessage

    private val _loading: MutableLiveData<Boolean> = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> get() = _loading


    fun getPhotos() {
        if (connectivity.hasInternetConnection()) {
            _loading.value = true
            viewModelScope.launch {
                galleryRepository.getPhotos(1).catch {
                    Log.e(TAG, "getPhotos: Exception")
                    _loading.value = false
                    _errorMessage.value = Constants.ERROR_MESSAGE
                }.cachedIn(viewModelScope).collectLatest {
                    _loading.value = false
                    _pagedPhotoList.value = it
                }
            }
        } else {
            _errorMessage.value = Constants.NO_NETWORK_CONNECTION
        }
    }

    fun showLoader(show:Boolean) {
        _loading.value = show
    }

}