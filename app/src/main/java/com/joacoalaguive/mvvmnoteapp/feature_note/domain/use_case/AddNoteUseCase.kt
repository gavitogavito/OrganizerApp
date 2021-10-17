package com.joacoalaguive.mvvmnoteapp.feature_note.domain.use_case

import android.content.res.Resources
import com.joacoalaguive.mvvmnoteapp.R
import com.joacoalaguive.mvvmnoteapp.feature_note.domain.model.InvalidNoteException
import com.joacoalaguive.mvvmnoteapp.feature_note.domain.model.Note
import com.joacoalaguive.mvvmnoteapp.feature_note.domain.repository.NoteRepository

class AddNoteUseCase(
    private val repository: NoteRepository
) {

    @Throws(InvalidNoteException::class)
    suspend operator fun invoke(note: Note) {
        if (note.title.isBlank()) {
            throw InvalidNoteException(Resources.getSystem().getString(R.string.exception_empty_title_note))
        }
        if (note.content.isBlank()) {
            throw InvalidNoteException(Resources.getSystem().getString(R.string.exception_empty_content_note))
        }
        repository.insertNote(note)
    }
}