webserver port 8081

h2 embedded db 
http://localhost:8081/console/l

db schema and some hard coded data present under src/main/resources/
data.sql
schema.sql


API Contract
############### USER CRUD #################
1. create user
http://localhost:8081/userDetails/user
{
  "user_name": "Jerry",
  "email": "def@gmail"

}
2. get all user
http://localhost:8081/userDetails/user


3. get user by id
http://localhost:8081/userDetails/user/{id}

4. delete user
http://localhost:8081/userDetails/user/{id}

########### CRUD playlist + add songs & tags + explore playlist songs ################

1. create playlist
http://localhost:8081/playlist
{
  "playlist_name": "party_list",
  "user_id": "1"
}
2. get all playlist
http://localhost:8081/playlist


3. get playlist by id 
http://localhost:8081/playlist/{id}

4. delete playlist
http://localhost:8081/playlist/{id}

5. add songs and tags
http://localhost:8081/playlist/addSongAndTag

{
  "playlist_id": 1,
  "song_id": 1,
  "tag_id": 1
}

6. explore songs
http://localhost:8081/playlist/exploreSongs/{id}

7. get playlist mapping
http://localhost:8081/playlist/playlistMapping/{id}

########### CRUD playlist + explore tag on playlist  ################

1. create tags
http://localhost:8081/tag
{
  "tag_name": "sufi"
}

2. get tags by id
http://localhost:8081/tag/{id}


3. get all tags
http://localhost:8081/tag


****** tagged playlist **********

4.  explore playlist by tag id
http://localhost:8081/tag/explorePlaylist?tagsIds=1,2

