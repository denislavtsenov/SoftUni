function songs(input) {
  class Song {
    constructor(type, name, time) {
      this.type = type;
      this.name = name;
      this.time = time;
    }
  }

  let songs = [];
  let numOfSongs = input.shift();
  let type = input.pop();

  for (let i = 0; i < numOfSongs; i++) {
    let [type, name, time] = input[i].split('_');

    let song = new Song(type, name, time);
    songs.push(song);
  }

  if (type === 'all') {
    songs.forEach(e => console.log(e.name));
  } else {
    songs.filter(e => e.type === type)
    .forEach(e => console.log(e.name));
  }
}



songs([4,
    'favourite_DownTown_3:14',
    'listenLater_Andalouse_3:24',
    'favourite_In To The Night_3:58',
    'favourite_Live It Up_3:48',
    'listenLater']
    );