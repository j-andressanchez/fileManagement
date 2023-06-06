Feature: Clonar un archivo de excel existente

  @clonarExcel
  Scenario Outline: Clonar un archivo de excel existente
    Given Se carga el archivo de excel <oldFilePath>
    When Se clona el archivo de excel cargado
    And Se guarda el nuevo archivo en <newFilePath>
    Then El archivo de Excel debe existir en <newFilePath>
    
    Examples:
   | oldFilePath                                              | newFilePath                                            |
   | "src\\test\\resources\\docs\\DatosAleatorios.xlsx"       | "src\\test\\resources\\docs\\newFile.xlsx"     |
      
  