package com.example.indiefinder.repository;

import com.example.indiefinder.entities.funkySong;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.List;

public interface funkySongRepo extends CrudRepository<funkySong, Long> {
    @Query(

            nativeQuery = true,
            value = "" +
                    "select \n" +
                    "songID\n" +
                    ",nameOfSong\n" +
                    ",genreName\n" +
                    ",albumName\n" +
                    ",releaseDate\n" +
                    ",artistName" +
                    ",if(albumID is null, 0, albumID)as albumID\n" +
                    "" +
                    "  from (\n" +
                    "\n" +
                    "\n" +
                    "select *\n" +
                    ", @rank5\\:=@rank5+1 AS rank\n" +
                    "from (\n" +
                    "select song.songID\n" +
                    "  , nameOfSong\n" +
                    "  , g3.name as genreName\n" +
                    "  , a.name as albumName\n" +
                    "  , releaseDate\n" +
                    "  , a.albumID\n" +
                    "  , a2.name as artistName\n" +
                    "  ,((NOW() - datePlayed)) as beans\n" +
                    "from song\n" +
                    "  join genre_song_intersection gsi on song.songID = gsi.songID\n" +
                    "  join genre g3 on gsi.genreID = g3.genreID\n" +
                    "  left join song_album_intersection i on song.songID = i.songID\n" +
                    "  left join album a on i.albumID = a.albumID\n" +
                    "  left join user_song_intersection_lastplayed lastplayed on song.songID = lastplayed.songID and lastplayed.userID = 1\n" +
                    "  left join song_artist_intersection intersection on song.songID = intersection.songID\n"+
                    "  left join artist a2 on intersection.artistID = a2.artistID \n" +
                    "\n" +
                    "where g3.genreID in (\n" +
                    "  select genreID\n" +
                    "  from(\n" +
                    "        select genreID\n" +
                    "          ,@rank4\\:=@rank4+1 AS rank\n" +
                    "        from (\n" +
                    "               select genreID\n" +
                    "                 ,  @rank\\:=@rank+1 AS rank\n" +
                    "                 ,  @rank2\\:=@rank2+@rank AS ranker\n" +
                    "                 , @rand\n" +
                    "                 , if(@rand > @rank2, \"no\", \"maybe\") as chance\n" +
                    "               from (\n" +
                    "                      select g.genreID as genreID\n" +
                    "                        ,IF(sums is null, 0, sums) as newSums\n" +
                    "                      from genre g\n" +
                    "                        left join (\n" +
                    "                                    select\n" +
                    "                                        g.genreID as genreID\n" +
                    "                                      , sum(IF(liked=1, 1, 0)) as isLikedMod\n" +
                    "                                      , sum(IF(liked  is null, .25, 0)) as isUnknownMod\n" +
                    "                                      , sum(IF(liked=0, -1, 0)) as isDislikedMod\n" +
                    "                                      , (sum(IF(liked=1, 1, 0)) + sum(IF(liked  is null, .25, 0)) + sum(IF(liked=0, -1, 0))) as sums\n" +
                    "\n" +
                    "\n" +
                    "                                    from user_song_intersection_lastplayed lp\n" +
                    "                                      left join (\n" +
                    "                                                  SELECT\n" +
                    "                                                    songID as songID,\n" +
                    "                                                    max(liked) as liked\n" +
                    "                                                  FROM user_song_intersection\n" +
                    "                                                  group by songID\n" +
                    "                                                ) as likedSongs\n" +
                    "                                        on likedSongs.songID = lp.songID\n" +
                    "                                      join genre_song_intersection g on lp.songID = g.songID\n" +
                    "                                      join genre g2 on g.genreID = g2.genreID\n" +
                    "                                    group by g.genreID\n" +
                    "                                  ) as listenedGs\n" +
                    "                          on g.genreID = listenedGs.genreID\n" +
                    "                      order by newSums\n" +
                    "                    ) as dumbo\n" +
                    "\n" +
                    "             ) as more where chance like \"maybe\"\n" +
                    "      ) as wow\n" +
                    "  where rank = 1\n" +
                    ")\n" +
                    "order by beans desc, releaseDate desc\n" +
                    ") as junk\n" +
                    "order by rank\n" +
                    ") as moreJunk\n" +
                    "where rank = 1;\n"

    )
    funkySong spGetSong();

    @Procedure(
            procedureName = "setBoiz"
    )
    void setTheBoiz();
}
