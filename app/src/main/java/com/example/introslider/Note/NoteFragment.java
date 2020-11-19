package com.example.introslider.Note;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;

import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.introslider.Note.adapter.NotesAdapter;
import com.example.introslider.Note.datebase.NotesDatabase;
import com.example.introslider.Note.entities.Note;
import com.example.introslider.Note.listeners.NoteListener;
import com.example.introslider.R;

import java.util.ArrayList;
import java.util.List;

import static android.app.Activity.RESULT_OK;

public class NoteFragment extends Fragment {

    public static final int REQUEST_CODE_ADD_NOTE = 1;
    public static final int REQUEST_CODE_UPDATE_NOTE = 2;
    private static final int REQUEST_CODE_SHOW_NOTES = 3;
    private static final int REQUEST_CODE_SELECT_IMAGE = 4;


    private RecyclerView noteRecyclerView;
    private List<Note> noteList;
    private NotesAdapter notesAdapter;
    private AlertDialog dialogAddURL;
    private int noteClickedPosition = -1;

    public NoteFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_note, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

            ImageView imageAddNoteMain =view.findViewById(R.id.imageAddNoteMain);
            imageAddNoteMain.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivityForResult(
                            new Intent(getContext(),
                                    CreateNoteActivty.class),
                            REQUEST_CODE_ADD_NOTE
                    );
                }
            });

            noteRecyclerView = view.findViewById(R.id.noteRecyclerView);
            noteRecyclerView.setLayoutManager(
                    new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            );

            noteList = new ArrayList<>();
            notesAdapter = new NotesAdapter(noteList,this::onNoteClicked);
            noteRecyclerView.setAdapter(notesAdapter);



            getNotes(REQUEST_CODE_SHOW_NOTES, false);
        }              //   end OnCreate


        public void onNoteClicked (Note note,int position){
            noteClickedPosition = position;
            Intent intent = new Intent(getContext(), CreateNoteActivty.class);
            intent.putExtra("isViewUpdate", true);
            intent.putExtra("note", note);
            startActivityForResult(intent, REQUEST_CODE_UPDATE_NOTE);
        }

        private void getNotes ( final int requestCode, final boolean isNoteDeleted){

            @SuppressLint("StaticFieldLeak")
            class GetNotesTask extends AsyncTask<Void, Void, List<Note>> {
                @Override
                protected List<Note> doInBackground(Void... voids) {
                    return NotesDatabase
                            .getDatabase(getContext())
                            .noteDao().getAllNotes();
                }

                @Override
                protected void onPostExecute(List<Note> notes) {
                    super.onPostExecute(notes);
                    if (requestCode == REQUEST_CODE_SHOW_NOTES) {
                        noteList.addAll(notes);
                        notesAdapter.notifyDataSetChanged();
                    } else if (requestCode == REQUEST_CODE_ADD_NOTE) {
                        noteList.add(0, notes.get(0));
                        notesAdapter.notifyItemChanged(0);
                        noteRecyclerView.smoothScrollToPosition(0);
                    } else if (requestCode == REQUEST_CODE_UPDATE_NOTE) {
                        noteList.remove(noteClickedPosition);
                        if (isNoteDeleted) {
                            notesAdapter.notifyItemRemoved(noteClickedPosition);
                        } else {
                            noteList.add(noteClickedPosition, notes.get(noteClickedPosition));
                            notesAdapter.notifyItemChanged(noteClickedPosition);
                        }
                    }

                }
            }
            new GetNotesTask().execute();
        }

        @Override
        public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
            super.onActivityResult(requestCode, resultCode, data);
            if (requestCode == REQUEST_CODE_ADD_NOTE && resultCode == RESULT_OK) {
                getNotes(REQUEST_CODE_ADD_NOTE, false);
            } else if (requestCode == REQUEST_CODE_UPDATE_NOTE && resultCode == RESULT_OK) {
                if (data != null) {
                    getNotes(REQUEST_CODE_UPDATE_NOTE, data.getBooleanExtra("isNoteDeleted", false));
                }

            } else if (requestCode == REQUEST_CODE_SELECT_IMAGE && resultCode == RESULT_OK) {
                if (data != null) {
                    Uri selectedImageUri = data.getData();
                    try {
                      //  String selectedImagePatch = getPatFromUrl(selectedImageUri);
                        Intent intent = new Intent(getContext(), CreateNoteActivty.class);
                        intent.putExtra("isFromQuickActions", true);
                        intent.putExtra("quickActionType", "image");
                      //  intent.putExtra("imagePath", selectedImagePatch);
                        startActivityForResult(intent, REQUEST_CODE_ADD_NOTE);


                    } catch (Exception exception) {
                        Toast.makeText(getContext(), exception.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }




    }

