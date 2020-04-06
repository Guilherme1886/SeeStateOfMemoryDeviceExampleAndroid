# SeeStateOfMemoryDeviceExampleAndroid
show using onTrimMemory() to view state of the memory of device

Componentes (Activity, Service ...) podem fazer o uso da interface ComponentCallback2 para ter acesso ao metodo
onTrimMemory(state: Int) onde retorna um estado e pode ser definido o que fazer quando o app esta com pouca memoria, ou 
quando o processo do app vai ser removido da pilha e outros mais.
