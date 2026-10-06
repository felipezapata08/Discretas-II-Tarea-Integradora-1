import munit.FunSuite

class ClosestPointsSuite extends FunSuite:

  test("distance between two points"):

    val point1 = List(0, 0)
    val point2 = List(3, 4)

    val result = ClosestPoints.distance(point1, point2)

    assertEquals(result, 5.0)


  test("distance between identical points"):

    val point1 = List(2, 3)
    val point2 = List(2, 3)

    val result = ClosestPoints.distance(point1, point2)

    assertEquals(result, 0.0)


  test("split points into two parts"):

    val points = List(
      List(1, 1),
      List(2, 2),
      List(3, 3),
      List(4, 4)
    )

    val result = ClosestPoints.splitPoints(points)

    assertEquals(
      result,
      (
        List(
          List(1, 1),
          List(2, 2)
        ),
        List(
          List(3, 3),
          List(4, 4)
        )
      )
    )


  test("sort points by x-coordinate"):

    val points = List(
      List(5, 2),
      List(1, 8),
      List(3, 4),
      List(2, 7)
    )

    val result = ClosestPoints.sortByX(points)

    assertEquals(
      result,
      List(
        List(1, 8),
        List(2, 7),
        List(3, 4),
        List(5, 2)
      )
    )


  test("sort points by y-coordinate"):

    val points = List(
      List(5, 2),
      List(1, 8),
      List(3, 4),
      List(2, 1)
    )

    val result = ClosestPoints.sortByY(points)

    assertEquals(
      result,
      List(
        List(2, 1),
        List(5, 2),
        List(3, 4),
        List(1, 8)
      )
    )


  test("closest distance between three points"):

    val points = List(
      List(0, 0),
      List(3, 4),
      List(1, 1)
    )

    val result = ClosestPoints.closestPoints(points)

    assertEqualsDouble(
      result,
      math.sqrt(2),
      0.0001
    )


  test("closest distance with duplicate points"):

    val points = List(
      List(0, 0),
      List(3, 4),
      List(0, 0),
      List(10, 10)
    )

    val result = ClosestPoints.closestPoints(points)

    assertEquals(result, 0.0)


  test("closest distance with negative coordinates"):

    val points = List(
      List(-5, -5),
      List(0, 0),
      List(-4, -4),
      List(10, 10)
    )

    val result = ClosestPoints.closestPoints(points)

    assertEqualsDouble(
      result,
      math.sqrt(2),
      0.0001
    )


  test("closest distance with two points"):

    val points = List(
      List(0, 0),
      List(3, 4)
    )

    val result = ClosestPoints.closestPoints(points)

    assertEquals(result, 5.0)


