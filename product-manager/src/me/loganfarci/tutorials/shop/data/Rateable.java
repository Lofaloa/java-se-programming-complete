/*
 * Copyright (C) 2021 Logan Farci

 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Java Trove Examples. If not, see <http://www.gnu.org/licenses/>.
 */
package me.loganfarci.tutorials.shop.data;

import static me.loganfarci.tutorials.shop.data.Rating.NOT_RATED;

@FunctionalInterface
public interface Rateable<T> {

    public static final Rating DEFAULT_RATING = NOT_RATED;

    public static Rating convert(int stars) {
        return (0 <= stars && stars <= 5) ? Rating.values()[stars] : DEFAULT_RATING;
    }

    public default Rating getRating() {
        return DEFAULT_RATING;
    }

    default T applyRating(int stars) {
        return applyRating(convert(stars));
    }

    T applyRating(Rating rating);

}
