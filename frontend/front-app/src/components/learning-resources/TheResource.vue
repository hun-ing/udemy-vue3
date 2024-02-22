<template>
  <BaseCard>
    <BaseButton @click="setSelectedTab(StoredResources)" :mode="storedResButtonMode">Stored Resources</BaseButton>
    <BaseButton @click="setSelectedTab(AddResource)" :mode="addResButtonMode">Add Resource</BaseButton>
  </BaseCard>
  <keep-alive>
    <component :is="selectedTab"></component>
  </keep-alive>
</template>

<script setup>
import {ref, provide, computed} from "vue";
import StoredResources from "@/components/learning-resources/StoredResources.vue";
import AddResource from "@/components/learning-resources/AddResource.vue";

const selectedTab = ref(StoredResources);

const resources = ref([
  {id: 'test1', title: 'Test1', description: 'test111', link: 'https://vuejs.org'},
  {id: 'test2', title: 'Test2', description: 'test222', link: 'https://google.org'},
]);

provide('resources', resources);
const setSelectedTab = (tab) => {
  selectedTab.value = tab;
}
const addResource = (title, description, link) => {
  const newResource = {
    id: new Date().toISOString(),
    title,
    description,
    link
  }

  resources.value.unshift(newResource);
  selectedTab.value = StoredResources;
}
provide('addResource', addResource);

const storedResButtonMode = computed(() => selectedTab.value.__name === StoredResources.__name ? null : 'flat');
const addResButtonMode = computed(() => selectedTab.value.__name === AddResource.__name ? null : 'flat');
const removeResource = (resId) => resources.value = resources.value.filter(resource => resource.id !== resId);
provide('removeResource', removeResource);
</script>

<style scoped>

</style>