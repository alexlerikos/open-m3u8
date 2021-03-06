package com.iheartradio.m3u8;

import java.util.ArrayList;
import java.util.List;

import com.iheartradio.m3u8.data.IFrameStreamInfo;
import com.iheartradio.m3u8.data.MasterPlaylist;
import com.iheartradio.m3u8.data.MediaData;
import com.iheartradio.m3u8.data.PlaylistData;
import com.iheartradio.m3u8.data.StreamInfo;

class MasterParseState implements IParseState<MasterPlaylist> {
    public final List<PlaylistData> playlists = new ArrayList<>();
    public final List<IFrameStreamInfo> iFramePlaylists = new ArrayList<>();
    public final List<MediaData> mediaData = new ArrayList<>();
    public final List<String> unknownTags = new ArrayList<>();
    
    public StreamInfo streamInfo;

    public boolean isDefault;
    public boolean isNotAutoSelect;

    public void clearMediaDataState() {
        isDefault = false;
        isNotAutoSelect = false;
    }

    @Override
    public MasterPlaylist buildPlaylist() throws ParseException {
        return new MasterPlaylist.Builder()
                .withPlaylists(playlists)
                .withIFramePlaylists(iFramePlaylists)
                .withMediaData(mediaData)
                .withUnknownTags(unknownTags)
                .build();
    }
}
