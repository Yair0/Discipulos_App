# Discipulos_App
Aplicación para concientizar acerca de la pobreza mundial en el 2020

# Alumnos
* Diego Moreno A01337594
* Jorge Germán Reyes A01336637
* Yair Yolotl Pimentel A01652823

## Descripción
1. Al abrir la app, se carga una Splash Screen con la info del proyecto.
1. La aplicación usa un JSON externo (https://datahelpdesk.worldbank.org/knowledgebase/articles/898581-api-basic-call-structures) que devuelve la lista de todos los países en el mundo y su nivel de ingresos económico. Después, carga la información de todos los países con un RecyclerView y con Volley en la app en forma de lista. 
1. Con el atributo iso2 del JSON, la aplicación manda a llamar las imágenes de todos los países de otra página (https://www.countryflags.io/) y las carga con Glide
1. Se puede hacer clic en cada país para ver su información más detallada. La imágen cargada en la pantalla de detalles dependerá del nivel de ingresos.
1. Si el ingreso de dicho país es bajo, se puede picar un botón para "Ayudar" al país.
