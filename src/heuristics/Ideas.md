FIXME: Borrar este archivo luego de implementar las ideas.

Algunas ideas para implementar heuristics en el proyecto:

# Exención de CapitalizedWords:

Se puede mejorar para sacar falsos positivos:

- Si la palabra esta al inicio de la oración o después de un punto, ignorarla si es: {"El", "Ella", "Como", ...}
- Si la la palabra esta en medio de la oración, agregarla si o si.

# Mas ideas:

- Mas de dos letras.
- Sin puntos o comas en el medio a no ser que este todo en mayuscula.
- Si la palabra esta al inicio de la oración o después de un punto, ignorarla si es: {"El", "Ella", "Como", ...} a no ser que este toda en mayuscula.
- Eliminamos palabras: de profesiones, ...
- luego de mr., ...

# Ideas que no le parecen al mati

- si esta todo en mayuscula
- luego de "el/ella profesiones".
- Palabras que empiecen con mayuscula y tengan tilde.
