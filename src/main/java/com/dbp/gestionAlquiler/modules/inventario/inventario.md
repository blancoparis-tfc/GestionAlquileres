# Inmueble

## Definición de la tabla Inmueble es una tabla que contiene los datos

Es la tabla principal que contiene los datos físicos y legales básicos.
Campo | Tipo de Dato | Descripción
-- | -- | --
id | UUID | Clave primaria.
referencia_catastral | String(20) | ID oficial en la Sede Electrónica del Catastro.
superficie_util | Decimal | Metros cuadrados útiles (pisables).
superficie_construida | Decimal | Metros cuadrados totales según catastro.
num_habitaciones_dobles | Integer | Cantidad de habitaciones de más de 10m².
num_habitaciones_indiv | Integer | Cantidad de habitaciones simples.
num_baños | Integer | Baños completos.
num_aseos | Integer | Aseos sin ducha/bañera.
año_construccion | Integer | Para cálculo de amortizaciones.
ultima_reforma | Integer | Año de la última actualización integral.
tiene_terraza | Boolean | Checkbox.
tiene_jardin | Boolean | Checkbox.
tiene_trastero | Boolean | Checkbox.
tiene_garaje | Boolean | Checkbox.