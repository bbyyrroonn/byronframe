<template>
  <div id="app">
    <login></login>
  </div>
</template>

<script>
  import 'common/css/bootstrap.css';
  import 'common/css/font-awesome.css';
  import 'common/css/beyond.css';

  import Login from 'components/login/login'

  export default {
    name: 'app',
    components: {
      Login
    }
  }
</script>

<style>

</style>
