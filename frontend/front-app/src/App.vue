<template>
  <div>
    <TheHeader></TheHeader>
    <BadgeList></BadgeList>
    <UserInfo
        :full-name="activeUser.name"
        :info-text="activeUser.description"
        :role="activeUser.role"
    ></UserInfo>
    <CourseGoals #default="slotProps">
        <h2>{{slotProps.item}}</h2>
        <p>{{slotProps.anotherProp}}</p>
    </CourseGoals>
  </div>
</template>

<script setup>
import TheHeader from "@/components/TheHeader.vue";
import BadgeList from "@/components/BadgeList.vue";
import UserInfo from "@/components/UserInfo.vue";
import {ref} from "vue";
import CourseGoals from "@/components/CourseGoals.vue";

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