<template>
  <div>
    <TheHeader></TheHeader>
    <BadgeList></BadgeList>
    <UserInfo
        :full-name="activeUser.name"
        :info-text="activeUser.description"
        :role="activeUser.role"
    ></UserInfo>
  </div>
</template>

<script setup>
import TheHeader from "@/components/TheHeader.vue";
import BadgeList from "@/components/BadgeList.vue";
import UserInfo from "@/components/UserInfo.vue";
import {ref} from "vue";

const activeUser = ref({
  name: 'Maximilian Schwarzmüller',
  description: 'Site owner and admin',
  role: 'admin',
});
</script>

<style>
html {
  font-family: sans-serif;
}

body {
  margin: 0;
}
</style>