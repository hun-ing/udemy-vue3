<template>
  <li >
    <div>
      <header>
        <h3>{{title}}</h3>
        <button>Delete</button>
      </header>
    </div>
    <p>{{description}}</p>
    <nav>
      <a :href="link">View Resource</a>
    </nav>
  </li>
</template>

<script setup>
defineProps(['title', 'description', 'link']);
</script>

<style scoped>

</style>