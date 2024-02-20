<template>
  <section>
    <header>
      <h1>목록</h1>
    </header>
    <NewFriend @add-contact="addContact"/>
    <ul>
      <FriendContact
          v-for="friend in friends"
          :key="friend.id"
          :id="friend.id"
          :name="friend.name"
          :phoneNumber="friend.phone"
          :emailAddress="friend.email"
          :isFavorite="friend.isFavorite"
          @toggle-favorite="toggleFavoriteStatus"
          @delete-friend="deleteContact"
      />
    </ul>
  </section>
</template>

<script setup>
import {ref} from "vue";
import FriendContact from "@/components/FriendContact.vue";
import NewFriend from "@/components/NewFriend.vue";

const friends = ref([
  {
    id: 'test1',
    name: '테스터1',
    phone: '010 0000 1111',
    email: 'test1@test.com',
    isFavorite: true,
  },
  {
    id: 'test2',
    name: '테스터2',
    phone: '010 0000 2222',
    email: 'test2@test.com',
    isFavorite: false,
  },
]);

const toggleFavoriteStatus = (friendId) => {
  const findFriend = friends.value.find(friend => friend.id === friendId);
  findFriend.isFavorite = !findFriend.isFavorite;
};

const addContact = (name, phone, email) => {
  const newFriendContact = {
    name,
    phone,
    email,
    id: new Date().toISOString(),
    isFavorite: false,
  }

  friends.value.push(newFriendContact);
}

const deleteContact = (friendId) => {
  friends.value = friends.value.filter(friend => friend.id !== friendId);
}

</script>

<style>
@import url('https://fonts.googleapis.com/css2?family=Jost&display=swap');

* {
  box-sizing: border-box;
}

html {
  font-family: 'Jost', sans-serif;
}

body {
  margin: 0;
}

header {
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.26);
  margin: 3rem auto;
  border-radius: 10px;
  padding: 1rem;
  background-color: #58004d;
  color: white;
  text-align: center;
  width: 90%;
  max-width: 40rem;
}

#app ul {
  margin: 0;
  padding: 0;
  list-style: none;
}

#app li,
#app form {
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.26);
  margin: 1rem auto;
  border-radius: 10px;
  padding: 1rem;
  text-align: center;
  width: 90%;
  max-width: 40rem;
}

#app h2 {
  font-size: 2rem;
  border-bottom: 4px solid #ccc;
  color: #58004d;
  margin: 0 0 1rem 0;
}

#app button {
  font: inherit;
  cursor: pointer;
  border: 1px solid #ff0077;
  background-color: #ff0077;
  color: white;
  padding: 0.05rem 1rem;
  box-shadow: 1px 1px 2px rgba(0, 0, 0, 0.26);
}

#app button:hover,
#app button:active {
  background-color: #ec3169;
  border-color: #ec3169;
  box-shadow: 1px 1px 4px rgba(0, 0, 0, 0.26);
}

#app input {
  font: inherit;
  padding: 0.15rem;
}
#app label {
  font-weight: bold;
  margin-right: 1rem;
  width: 7rem;
  display: inline-block;
}
#app form div {
  margin: 1rem 0;
}
</style>
